/*
 * The MIT License
 *
 * Copyright 2017 evertonramos.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.everton.html5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HTML5
 *
 * @author evertonramos
 */
public abstract class Html5 {

    private final StringBuilder sbContent = new StringBuilder();
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    private void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Html5(String tagName) {
        setTagName(tagName);
    }

    public Html5(String tagName, String content) {
        setTagName(tagName);
        append(content);
    }

    public Html5(String tagName, Html5 content) {
        setTagName(tagName);
        append(content);
    }
    
    /**
     * special attribute?
     */
    private final List<String> specialAttribute = new ArrayList<>();
    
    public void addSpecialAttribute(String name) {
        specialAttribute.add(name);
    }
    
    public void addSpecialAttribute(String[] names) {
        for (int i = 0; names.length > i; i++) {
            addSpecialAttribute(names[i]);
        }
    }
    
    private String getSpecialAttribute() {
        return String.join(" ", specialAttribute);
    }

    /**
     * Specifies one or more classnames for an element (refers to a class in a
     * style sheet)
     */
    private final List<String> classAttribute = new ArrayList<>();

    /**
     * add class name
     *
     * @param name class name
     */
    public void addClassName(String name) {
        classAttribute.add(name);
    }

    /**
     * add class names
     *
     * @param names String[]{"name1", "name2", "nameN"}
     */
    public void addClassName(String[] names) {
        for (int i = 0; names.length > i; i++) {
            addClassName(names[i]);
        }
    }

    /**
     * get string with class names separated by spaces
     *
     * @return something like: class1 class2 classN
     */
    private String getClassAttribute() {
        return String.join(" ", classAttribute);
    }

    /**
     * Used to store custom data private to the page or application
     */
    private final Map<String, String> dataAttribute = new HashMap<>();

    /**
     * add data attribute
     *
     * @param attribute attribute name
     * @param value attribute value
     */
    public void addDataAttribute(String attribute, String value) {
        dataAttribute.put("data-" + attribute, value);
    }

    /**
     * get string with data attributes separated by spaces
     *
     * @return something like: data-attribute1='value' data-attribute2='value'
     * data-attributeN='value'
     */
    private String getDataAttributes() {
        StringBuilder sb = new StringBuilder();

        dataAttribute.forEach((key, value) -> {
            sb.append(key).append("='").append(value).append("' ");
        });

        return sb.toString().trim();
    }

    /**
     * Specifies that an element is not yet, or is no longer, relevant
     */
    private boolean hiddenAttribute = false;

    /**
     * get hidden attribute value
     *
     * @return hidden attribute value
     */
    public boolean isHiddenAttribute() {
        return hiddenAttribute;
    }

    /**
     * set hidden attribute value
     *
     * @param hiddenAttribute hidden attribute value
     */
    public void setHiddenAttribute(boolean hiddenAttribute) {
        this.hiddenAttribute = hiddenAttribute;
    }

    /**
     * Specifies a unique id for an element
     */
    private String idAttribute = "";

    /**
     * get id attribute value
     *
     * @return id attribute value
     */
    public String getIdAttribute() {
        return idAttribute;
    }

    /**
     * set id attribute value
     *
     * @param idAttribute id attribute value
     */
    public void setIdAttribute(String idAttribute) {
        this.idAttribute = idAttribute;
    }

    /**
     * Specifies an inline CSS style for an element
     */
    private final Map<String, String> styleAttribute = new HashMap<>();

    /**
     * add style
     *
     * @param property property name
     * @param value property value
     */
    public void addStyle(String property, String value) {
        styleAttribute.put(property, value);
    }

    /**
     * get string with style properties separated by semicolons
     *
     * @return something like: property1:value;property2:value;propertyN:value;
     */
    private String getStyleAttribute() {
        StringBuilder sb = new StringBuilder();

        styleAttribute.forEach((key, value) -> {
            sb.append(key).append(":").append(value).append(";");
        });

        return sb.toString();
    }

    /**
     * Specifies extra information about an element
     */
    private String titleAttribute = "";

    /**
     * get title attribute value
     *
     * @return title attribute value
     */
    public String getTitleAttribute() {
        return titleAttribute;
    }

    /**
     * set title attribute value
     *
     * @param titleAttribute title attribute value
     */
    public void setTitleAttribute(String titleAttribute) {
        this.titleAttribute = titleAttribute;
    }

    /**
     * Used to store custom attributes
     */
    private final Map<String, String> customAttribute = new HashMap<>();

    /**
     * add custom attribute
     *
     * @param attribute attribute name
     * @param value attribute value
     */
    public void addCustomAttribute(String attribute, String value) {
        customAttribute.put(attribute, value);
    }

    /**
     * get string with custom attributes separated by spaces
     *
     * @return something like: attribute1='value' attribute2='value'
     * attributeN='value'
     */
    private String getCustomAttributes() {
        StringBuilder sb = new StringBuilder();

        customAttribute.forEach((key, value) -> {
            sb.append(key).append("='").append(value).append("' ");
        });

        return sb.toString().trim();
    }

    /**
     * get string with attributes
     *
     * @return something like: class='...' id='...' style='...' title='...'
     */
    public String getAttributes() {
        StringBuilder sb = new StringBuilder();

        // class
        if (!getClassAttribute().isEmpty()) {
            sb.append("class='").append(getClassAttribute()).append("' ");
        }

        // data-*
        if (!getDataAttributes().isEmpty()) {
            sb.append(getDataAttributes()).append(" ");
        }

        // hidden
        if (isHiddenAttribute()) {
            //sb.append("hidden ");
            addSpecialAttribute("hidden");
        }

        // id
        if (!getIdAttribute().isEmpty()) {
            sb.append("id='").append(getIdAttribute()).append("' ");
        }

        // style
        if (!getStyleAttribute().isEmpty()) {
            sb.append("style='").append(getStyleAttribute()).append("' ");
        }

        // title
        if (!getTitleAttribute().isEmpty()) {
            sb.append("title='").append(getTitleAttribute()).append("' ");
        }

        // custom
        if (!getCustomAttributes().isEmpty()) {
            sb.append(getCustomAttributes()).append(" ");
        }
        
        // special
        if (!getSpecialAttribute().isEmpty()) {
            sb.append(getSpecialAttribute());
        }

        return sb.toString().trim();
    }

    public final void comment(String comment) {
        sbContent.append(new Comment(comment));
    }

    public final void br() {
        sbContent.append(new Br());
    }

    public final void br(int times) {
        for (int x = 0; x < times; x++) {
            br();
        }
    }

    public final void h1(String heading) {
        sbContent.append(new H1(heading));
    }

    public final void h2(String heading) {
        sbContent.append(new H2(heading));
    }

    public final void h3(String heading) {
        sbContent.append(new H3(heading));
    }

    public final void h4(String heading) {
        sbContent.append(new H4(heading));
    }

    public final void h5(String heading) {
        sbContent.append(new H5(heading));
    }

    public final void h6(String heading) {
        sbContent.append(new H6(heading));
    }

    public final void hr() {
        sbContent.append(new Hr());
    }

    public final void append(String content) {
        sbContent.append(content);
    }

    public final void append(Html5 html) {
        sbContent.append(html);
    }

    // css
    public final void setWidth(int width) {
        addStyle("width", Integer.toString(width) + "px");
    }

    public final void setHeight(int height) {
        addStyle("height", Integer.toString(height) + "px");
    }

    public enum TextAlign {
        /**
         * Aligns the text to the left
         */
        LEFT,
        /**
         * Aligns the text to the right
         */
        RIGHT,
        /**
         * Centers the text
         */
        CENTER,
        /**
         * Stretches the lines so that each line has equal width (like in
         * newspapers and magazines)
         */
        JUSTIFY,
        /**
         * Sets this property to its default value
         */
        INITIAL,
        /**
         * Inherits this property from its parent element
         */
        INHERIT;

        @Override
        public String toString() {
            switch (this) {
                case RIGHT:
                    return "right";
                case CENTER:
                    return "center";
                case JUSTIFY:
                    return "justify";
                case INITIAL:
                    return "initial";
                case INHERIT:
                    return "inherit";
                default:
                    return "left";
            }
        }
    }

    public final void setTextAlign(TextAlign textAlign) {
        addStyle("text-align", textAlign.toString());
    }

    public enum FontWeight {
        /**
         * Defines normal characters. This is default
         */
        NORMAL,
        /**
         * Defines thick characters
         */
        BOLD,
        /**
         * Defines thicker characters
         */
        BOLDER,
        /**
         * Defines lighter characters
         */
        LIGHTER,
        /**
         * Defines from thin to thick characters. 400 is the same as normal, and
         * 700 is the same as bold
         */
        N100,
        N200,
        N300,
        N400,
        N500,
        N600,
        N700,
        N800,
        N900,
        /**
         * Sets this property to its default value
         */
        INITIAL,
        /**
         * Inherits this property from its parent element
         */
        INHERIT;

        @Override
        public String toString() {
            switch (this) {
                case BOLD:
                    return "bold";
                case BOLDER:
                    return "bolder";
                case LIGHTER:
                    return "lighter";
                case N100:
                    return "100";
                case N200:
                    return "200";
                case N300:
                    return "300";
                case N400:
                    return "400";
                case N500:
                    return "500";
                case N600:
                    return "600";
                case N700:
                    return "700";
                case N800:
                    return "800";
                case N900:
                    return "900";
                case INITIAL:
                    return "initial";
                case INHERIT:
                    return "inherit";
                default:
                    return "normal";
            }
        }
    }

    public final void setFontWeight(FontWeight fontWeight) {
        addStyle("font-weight", fontWeight.toString());
    }

    public final String getHtml5(boolean indentation) {
        StringBuilder html5 = new StringBuilder();

        if (getTagName().equals("html")) {
            html5.append(new Doctype());
        }

        html5.append("<");
        html5.append(getTagName());
        html5.append(getAttributes().isEmpty() ? "" : (" " + getAttributes()));

        switch (getTagName()) {
            case "!DOCTYPE":
                // doctype
                html5.append(" html>");
                html5.append(sbContent);
                break;
            case "!--":
                // comment
                html5.append(sbContent);
                html5.append("-->");
                break;
            case "input":
            case "br":
            case "hr":
                html5.append(">");
                html5.append(sbContent);
                break;
            default:
                // others
                html5.append(">");
                html5.append(sbContent);
                html5.append("</").append(getTagName()).append(">");
                break;
        }

        if (!indentation) {
            return html5.toString();
        } else { // todo need make an indentation function
            return html5.toString().replaceAll("\\><", ">\n<");
        }

    }

    @Override
    public String toString() {
        return getHtml5(false);
    }
}
