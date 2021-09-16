import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.h1
import kotlinx.css.h2
import react.dom.ReactHTML.button
import react.dom.ReactHTML.h1
import react.dom.ReactHTML.h2
import react.dom.div
import util.PushManagerState
import util.ServiceWorkerState
import util.usePushManager
import util.useServiceWorker
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.js.onClickFunction

fun mainnn() {

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