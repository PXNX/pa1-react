import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.div

fun main() {

//   addServiceWorker()

    sw()


    window.onload = {
        render(document.getElementById("root")) {


                child(Title::class) {
                    attrs {
                        name = "React!"
                    }
                }

                child(Feed::class) {}


                /*  child(ImageList::class) {
                this.attrs {
                    listOf("res/wallpaper2.jpg")
                }
            }

          */

            }
        }
    }