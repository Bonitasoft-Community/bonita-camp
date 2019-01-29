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
2. Download [Ant-Contrib 1.0b2](http://sourceforge.net/projects/ant-contrib/files/ant-contrib/ant-contrib-1.0b2/ant-contrib-1.0b2-bin.zip/download)
3. Open Eclipse preferences and navigating to `Ant / Runtime`
4. Select the `Classpath` tab and add the Ant-Contrib JAR as an external JAR under `Global Entries`
5. Create a docbook project from the `exercices` folder
6. Locate your eclipse plugin configuration path in the console output by performing a first build. The path should be something similar to this: `eclipse/configuration/org.eclipse.osgi/433/0/.cp/resources/`
7. Overwrite your configuration files with the content of `custom-template` (some files should be overwritten).

## Build instructions for exercises
With the exercises project set up, you may build the instructions in Eclipse:
- as a PDF by running the Ant "PDF" target
- as a ZIP file with corrections by running the Ant "Package as ZIP" target
