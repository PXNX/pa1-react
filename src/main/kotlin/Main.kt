import kotlinext.js.jsObject
import kotlinx.browser.document
import react.dom.render

fun main(){
    render(document.getElementById("root")) {
        App(props = jsObject(), handler = {})
    }
}