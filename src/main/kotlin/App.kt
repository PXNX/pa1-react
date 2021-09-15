import component.loadingComponent
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.*
import react.dom.ReactHTML.button
import react.dom.ReactHTML.h1
import react.dom.ReactHTML.h2
import util.PushManagerState
import util.ServiceWorkerState
import util.usePushManager
import util.useServiceWorker


val scope = MainScope()

val App = functionComponent<Props> {

    val serviceWorkerState = useServiceWorker()
    val (pushManagerState, subscribeUser, unsubscribeUser) = usePushManager(
        serviceWorkerState = serviceWorkerState,
        publicKey = "BLceSSynHW5gDWDz-SK5mmQgUSAOzs_yXMPtDO0AmNsRjUllTZsdmDU4_gKvTr_q1hA8ZX19xLbGe28Bkyvwm3E"
    )

    when (serviceWorkerState) {
        is ServiceWorkerState.Registered -> {
            h1 {
                +"Successfully registered a service worker!"
            }
            when (pushManagerState) {
                is PushManagerState.NotSubscribed -> {
                    button {
                        attrs {
                            onClick= {
                                scope.launch {
                                    subscribeUser(pushManagerState) {
                                        console.log("Sending subscription to server...")
                                    }
                                }
                            }
                        }
                        +"Click here to subscribe to push notifications"
                    }
                }
                is PushManagerState.Subscribed -> {
                    h2 {
                        +"User is subscribed to Push API"
                    }
                    button {
                        attrs {
                            onClick = {
                                scope.launch {
                                    unsubscribeUser(pushManagerState)
                                }
                            }
                        }
                        +"Click here to unsubscribe"
                    }
                }
                PushManagerState.NotSupported -> h2 {
                    +"Push API is not supported on this browser"
                }
                PushManagerState.Loading, PushManagerState.NotLoaded -> loadingComponent()
            }
        }
        is ServiceWorkerState.Failed -> h1 {
            +"Error in registering service worker: ${serviceWorkerState.exception.message}"
        }
        ServiceWorkerState.Loading -> {
            println("---------------- LOADING")
            loadingComponent()
        }
    }
}


fun RBuilder.App(props: Props, handler:RHandler<Props>) = child(App,props,handler)