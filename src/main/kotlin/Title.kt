import kotlinx.css.*
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.a
import react.dom.attrs
import react.dom.nav
import styled.*

external interface TitleProps : Props {
    var name: String
}

data class TitleState(val name: String) : State

@OptIn(ExperimentalJsExport::class)
@JsExport
class Title(props: TitleProps) : RComponent<TitleProps, TitleState>(props) {

    init {
        state = TitleState(props.name)
    }

    override fun RBuilder.render() {

        styledNav {
            css {
                //   margin = "1rem"
                backgroundColor = Color("#0c2b49")
                //   overflow = Overflow.hidden
                position = Position.fixed
                display = Display.block

                top = 0.px
                left = 0.px
                right = 0.px

                width = LinearDimension("100%")

            }







                styledImg(src = "./logo/logo-192.png", alt = "Militaernews") {
                    attrs {
                        width = "45"
                        height = "45"
                    }

                    css {
                        float = Float.left
                        padding = "0.5rem"
                    }
                }






            styledDiv {
                css {


                    backgroundColor = Color("#4455aa")

                    float = Float.right
                    //  display = Display.inlineFlex

                    //  alignItems=Align.center
                }

                styledA("/") {
                    styledImg(src = "icon/telegram.svg", alt = "Telegram") {
                        attrs {

                            width = "32"
                            height = "32"
                        }


                    }


                }



                styledA("/") {
                    styledImg(src = "icon/twitter.svg", alt = "Twitter") {
                        attrs {
                            width = "32"
                            height = "32"
                        }

                        css {
                            padding = "0.3rem"
                        }
                    }

                    css{
                        height= LinearDimension.fillAvailable
                    }
                }

                a("/") {
                    styledImg(src = "icon/icon-mail.svg", alt = "Mail") {
                        attrs {
                            width = "32"
                            height = "32"

                        }

                        css {
                            padding = "0.5rem"
                        }
                    }

                }


            }
        }
    }
}
