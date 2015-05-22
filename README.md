BPM Camp
====================

Slides and exercises for the BPM Camp events.

Content is available in:
- English
- French
- Spanish

##Build instructions for slides
1. Download [reveal.js](https://github.com/hakimel/reveal.js/) version 2.6.2
2. Paste the content of the "slides" folder into your reveal install directory
3. Download and install the [Bonita reveal.js theme](https://github.com/amottier/bonitasoft-adoption) in your reveal.js "css\theme" folder

##Build instructions for exercises
1. Install the [DEP4E eclipse plugin](http://dep4e.sourceforge.net/)
2. Create a project from the "exercices" folder
3. Locate your eclipse plugin configuration path in the console output by performing a first build. The path should be something similar to this: eclipse/configuration/org.eclipse.osgi/433/0/.cp/resources/
4. Overwrite your configuration files with the content of "custom-template" (some files should be overwritten).
