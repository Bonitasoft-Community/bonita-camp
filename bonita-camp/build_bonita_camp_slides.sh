#!/bin/bash
# THE SCRIPT IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED

##################################################################
# This script builds bonita-camp slides as per the instructions at:
# https://github.com/Bonitasoft-Community/bonita-camp#build-instructions-for-slides
# It has been tested on Ubuntu 18.04 and should work on most GNU/Linux.
##################################################################

# The working folder. You may change this.
folder=~/bonita_camp

# By default, pdf are not generated at the end
# Change the following 'false' to 'true' (without quotes) to generate pdf files.
# This is experimental (use at your own risk)
# Tested with Chromium 71.0.3578.98
generate_pdf=false

# Testing that required packages are installed
for pkg in unzip npm wget unzip node-grunt-cli; do
    if dpkg --get-selections | grep -q "^$pkg[[:space:]]*install$" >/dev/null; then
        echo -e "$pkg is installed."
    else
        echo "Package '$pkg' needs to be installed first. Exiting."
        exit 1
    fi
done


# Create the working folder if it does not exist
mkdir -p $folder
cd $folder

# Dowload required files. With --no-clobber, we do not download files already there
wget --no-clobber https://github.com/hakimel/reveal.js/archive/3.8.0.zip
wget --no-clobber https://github.com/Bonitasoft-Community/bonita-camp/archive/7.x.zip
unzip 7.x.zip

# You can delete one or two of 'en' (English), 'fr' (French) or 'es' (Spanish)
# if you do not need the 3 languages
    for language in en fr es
    {
        echo "Generating slides for language: $language"
        cd $folder
        rm -f -r $folder/reveal.js-3.8.0
        unzip 3.8.0.zip
        cp -a $folder/bonita-camp-7.x/slides/theme/. $folder/reveal.js-3.8.0/css/theme/source/

        cp -a $folder/bonita-camp-7.x/slides/$language/. $folder/reveal.js-3.8.0/

        cd $folder/reveal.js-3.8.0
        npm install
        # Original instructions for building slides at https://github.com/Bonitasoft-Community/bonita-camp
        # say that one should run 'npm install -g grunt-cli' at this stage
        # but this requires root or sudo privileges, which we prefer to avoid in a script.
        # Installing the 'node-grunt-cli' package instead seems to be enough.

        # Build the presentation slides and unzip them
        grunt package
        mv $folder/reveal.js-3.8.0/reveal-js-presentation.zip $folder/bonita_camp_7.10_slides_$language.zip
        cd $folder
        mkdir -p $folder/bonita_camp_7.10_slides_$language
        unzip bonita_camp_7.10_slides_$language.zip -d $folder/bonita_camp_7.10_slides_$language

        # Spanish slides have a slightly different structure, with images in /presentation_images, not in /images
        # TODO: this should probably not be required if the slides source files were correct for Spanish
        if [ -d "$folder/reveal.js-3.8.0/presentation_images" ]; then
        cp -r $folder/reveal.js-3.8.0/presentation_images $folder/bonita_camp_7.10_slides_$language/presentation_images
        fi
        
        # The pdf can then be built opening the presentation with chromium and printing as a pdf file.

        # Test if we generate pdf automatically (following is optional and experimental)
        case $generate_pdf in (true) {
            echo "Generating pdf file for language: $language"
            cp $folder/bonita_camp_7.10_slides_$language/css/print/paper.css $folder/bonita_camp_7.10_slides_$language/css/print/paper_portrait_backup.css
            
            # Remove the last curly bracket (end of file), add @page {size: landscape}, and the curly bracket again
            head -n -1 $folder/bonita_camp_7.10_slides_$language/css/print/paper.css > $folder/bonita_camp_7.10_slides_$language/css/print/paper_temp.css
            echo " @page {size: landscape} }" >> $folder/bonita_camp_7.10_slides_$language/css/print/paper_temp.css
            mv -f $folder/bonita_camp_7.10_slides_$language/css/print/paper_temp.css $folder/bonita_camp_7.10_slides_$language/css/print/paper.css
            
            # Generate the pdf
            chromium-browser --headless --print-to-pdf=$folder/bonita_camp_7.10_slides_$language.pdf $folder/bonita_camp_7.10_slides_$language/index.html
        }
        esac

}
