Bonita Camp - 7.x
====================

Slides and exercises for the Bonita Camp events.

Content is available in:
- English (Bonita Camp 7.8)
- Français (Bonita Camp 7.7)
- Español (Bonita BPM 7.2)

## Get the latest version
You can get the latest version of slides and exercices by downloading the [latest release](https://github.com/Bonitasoft-Community/bonita-camp/releases/latest) from GitHub.

## Build instructions for slides
1. Download and unzip [reveal.js version 3.7.0](https://github.com/hakimel/reveal.js/releases/tag/3.7.0)
2. Paste the content of the `slides/THE_LANGUAGE/` folder into your `reveal.js` directory
3. Paste the content of the `slides/theme` folder in your `reveal.js/css/theme/source` folder
4. Run `npm install`
5. Run `npm install -g grunt-cli`
6. Run `grunt package`

## Setup instructions for exercises
1. Download and install the [DEP4E eclipse plugin](http://dep4e.sourceforge.net/)
2. Download [Ant-Contrib 1.0b2](http://sourceforge.net/projects/ant-contrib/files/ant-contrib/ant-contrib-1.0b2/ant-contrib-1.0b2-bin.zip/download) and unzip it (creating an `ant-contrib` folder with a `lib` subfolder in it).
3. Open Eclipse preferences (Menu: Windows / Preference) and navigate to `Ant / Runtime`
4. Select the `Classpath` tab and add the Ant-Contrib JAR (in the /ant-contrib/lib/ folder) as an external JAR under `Global Entries`. Click `Apply and Close`.
5. Create a docbook project from the `exercices` folder. To do so, in Eclipse, open the menu `File / Open Projects from File System...`, and enter the path of the `exercices` folder as the `Import source`. In Eclipse's Package Explorer, expand the `exercices` folder, right-click on `build.xml` and select `Run as / Ant Build`. The last two lines of the build log should look like these (where [root_path] is the place where you unzipped the source files):
```
[fop] [root_path]/bonita-camp-7.x/exercices/target/en/xsl-fo/docbook.fo -> [root_path]/bonita-camp-7.x/exercices/target/en/xsl-fo/docbook.pdf
[move] Moving 1 file to [root_path]/bonita-camp-7.x/exercices/target/en
```
6. Locate your eclipse plugin configuration path in the console output by performing a first build. The path should be something similar to this: `eclipse/configuration/org.eclipse.osgi/433/0/.cp/resources/` (search near the beginning of the console log a line starting with `[xslt] Loading stylesheet...`
7. Overwrite your configuration files with the content of `custom-template` (some .xml and .xsl files should be overwritten); do this by putting the `docbook-xsl-ns` folder that is in the `exercices/custom-template` folder into the `/.cp/resources/` folder that you found at the previous step.

## Build instructions for exercises
With the exercises project set up, you may build the instructions in Eclipse:
- as a PDF by running the Ant "PDF" target
- as a ZIP file with corrections by running the Ant "Package as ZIP" target
To do the above, right-click on the `build.xml` file in Eclipse's Package Explorer, select `Run as/Ant build...` and check the "Package as ZIP" and/or "PDF" tick boxes.
