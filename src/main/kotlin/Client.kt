import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.div

fun main() {

    addServiceWorker()


    window.onload = {
        render(document.getElementById("root")) {

            child(Title::class) {
                attrs {
                    name = "React!"
                }
            }

         /*  child(ImageList::class) {
                this.attrs {
                    listOf("res/wallpaper2.jpg")
                }
            }

          */


        }
    }
}
