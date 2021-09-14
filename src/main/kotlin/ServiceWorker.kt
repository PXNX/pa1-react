import kotlinx.browser.window
import org.w3c.dom.events.EventListener

fun addServiceWorker() {
    val navigator = window.navigator
    console.log("adding service worker ${navigator.serviceWorker}")

    window.addEventListener("load", EventListener {
        console.log("load event listener")

        navigator.serviceWorker.register("/count.js").then(
            onFulfilled = {
                console.log("ServiceWorker registration successful with scope: ", it.scope)
            }
            , onRejected = {
                console.log("ServiceWorker registration failed: ", it.message);
            }
        )
    })

}

