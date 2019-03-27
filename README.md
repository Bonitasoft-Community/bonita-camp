Bonita Camp - 7.x
====================

Slides and exercises for the Bonita Camp events.

Content is available in:
- English (Bonita Camp 7.8)
- Français (Bonita Camp 7.8)
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

## Setup instructions to build exercises
1. Download and install [Saxon-HE 9.9](https://www.saxonica.com/download/java.xml)
2. Download and install it [Apache FOP 2.3](https://xmlgraphics.apache.org/fop/download.html)
3. Download and unzip [DocBook XSLT 2.0 stylesheets](https://github.com/docbook/xslt20-stylesheets/releases)


## Build instructions for exercises
1. Open a terminal and go to: exercices/source/[en,fr,es]
2. Run `java -cp ~/SaxonHE9-9-1-2J/saxon9he.jar net.sf.saxon.Transform -xi -t -s:exercises.xml -xsl:~/docbook-xslt2-2.3.11/xslt/base/fo/final-pass.xsl -o:exercises.fo page.margin.inner=0.25i` command (adapt path to Saxon and stylessheets installation folders)
3. Run `fop exercises.fo exercises.pdf`

## Validation of exercices DocBook files
You can validate the files using xmllint tool: `xmllint --xinclude --schema ./exercices/schemas/docbook.xsd --noout ./exercices/source/en/exercises.xml`