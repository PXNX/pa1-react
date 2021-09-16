import component.loadingComponent
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.html.js.onClickFunction
import react.Props
import react.RBuilder
import react.RHandler
import react.dom.attrs
import react.dom.button
import react.dom.h1
import react.dom.h2
import react.functionComponent
import util.PushManagerState
import util.ServiceWorkerState
import util.usePushManager
import util.useServiceWorker

val scope = MainScope()


val serviceWorkerState = useServiceWorker()

val pushManager = usePushManager(
    serviceWorkerState = serviceWorkerState,
    publicKey = "BLceSSynHW5gDWDz-SK5mmQgUSAOzs_yXMPtDO0AmNsRjUllTZsdmDU4_gKvTr_q1hA8ZX19xLbGe28Bkyvwm3E"
)

val App = functionComponent<Props> {



    when (serviceWorkerState) {
        is ServiceWorkerState.Registered -> {
            h1 {
                +"Successfully registered a service worker!"
            }

            child(Title::class) {
                attrs {
                    name = "React!"
                }
            }

            child(Feed::class) {
                attrs {
                    pushManagerState = pushManager.pushManagerState
                }
            }


        }
        is ServiceWorkerState.Failed -> h1 {
            +"Error in registering service worker: ${serviceWorkerState.exception.message}"
        }
        ServiceWorkerState.Loading -> loadingComponent()
    }
}

fun RBuilder.App(props: Props, handler: RHandler<Props>) = child(App, props, handler)