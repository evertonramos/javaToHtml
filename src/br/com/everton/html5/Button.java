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

/**
 * Defines a clickable button
 *
 * @author evertonramos
 */
public class Button extends Html5 {
    public Button() {
        super("button");
    }
    
    public Button(String content) {
        super("button", content);
    }
    
    /**
     * The type attribute specifies the type of button.
     */
    public enum Type {
        /**
         * The button is a clickable button
         */
        TButton,
        /**
         * The button is a submit button (submits form-data)
         */
        TSubmit,
        /**
         * The button is a reset button (resets the form-data to its initial values)
         */
        TReset;

        @Override
        public String toString() {
            switch (this) {
                case TSubmit:
                    return "submit";
                case TReset:
                    return "reset";
                default:
                    return "button";
            }
        }
    }
    
    public void setType(Type type) {
        addCustomAttribute("type", type.toString());
    }
    
}
