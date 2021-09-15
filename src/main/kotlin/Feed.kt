import component.iconButton
import kotlinx.browser.window
import kotlinx.css.*
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.col
import react.dom.div
import styled.*
import util.isLandscape
import util.isPortrait


@OptIn(ExperimentalJsExport::class)
@JsExport
class Feed : RComponent<Props, State>() {
    override fun RBuilder.render() {

        val paths = emptyList<String>().toMutableList()

        for (i in 0..30) {
            paths.addAll(listOf("wallpaper1.webp", "wallpaper2.jpg", "wallpaper3.png"))
        }

        if (isPortrait) {
            styledDiv {
                console.log("------- " + window.navigator.platform)

                css {
                    //     backgroundColor = Color.blue
                    display = Display.grid// Display.flex
                    gridTemplateColumns = GridTemplateColumns(GridAutoRows("1fr"))
                    justifyContent = JustifyContent.center
                    //              alignItems=Align.center
                    rowGap = LinearDimension("1em")

                    margin(top = 80.px)
//               height=LinearDimension("50vh")

                }

                paths.forEachIndexed { index, path ->

                    if (index % 12 == 0) {
                        styledDiv {
                            css {
                                backgroundColor = Color("#016b6b")

                                width = LinearDimension.fillAvailable

                                borderRadius = LinearDimension("16px")


                                padding = "1.5rem"
                            }


                            +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"


                            styledButton {
                                +"Auf dem Laufenden bleiben (push notification)"

                                attrs {

                                }
                            }


                        }
                    }




                    styledDiv {
                        css {
                            backgroundColor = Color("#0c2b49")

                            //   display=Display.grid
                            //    alignItems=Align.center
                            //  justifyContent=JustifyContent.center

                            width = LinearDimension.fillAvailable

                            borderRadius = LinearDimension("16px")


                            margin(bottom = LinearDimension("1.25rem"))
                        }







                        styledImg(src = path) {


                            attrs {
                                width = "100%"
                                height = "120px"


                            }

                            css {

                                borderTopRightRadius = LinearDimension("16px")
                                borderTopLeftRadius = LinearDimension("16px")
                                overflow = Overflow.hidden
                            }


                        }


                        styledP {
                            +"<b>Titel des Artikels</b>\n"
                            +"Hier passierte etwas. Lesen Sie hier weiter und hier kommt noch Text..."

                            css {

                                margin(LinearDimension("0.75rem"))
                            }
                        }

                    }
                }




                styledDiv {
                    css {
                        backgroundColor = Color("#016b6b")

                        width = LinearDimension.fillAvailable

                        borderRadius = LinearDimension("16px")


                        margin(bottom = LinearDimension("15rem"))
                        padding = "1.5rem"
                    }


                    +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"


                    styledButton {
                        +"Auf dem Laufenden bleiben (push notification)"

                        attrs {

                        }
                    }

                }
            }


            styledDiv {
                css {


                    backgroundColor = Color("#0c2b49")

                    float = Float.right
                    display = Display.block
                    bottom = 0.px
                    left = 0.px
                    right = 0.px
                    position = Position.fixed
                    //margin(right=50.px)
                    //  alignItems=Align.center
                }

                iconButton("https://t.me/militaernews", "telegram")

                iconButton("https://twitter.com/MilitaerNews?s=09", "twitter")

                //   iconButton("mailto:militaernews@protonmail.com", "icon-mail")
            }


        } else if (isLandscape) {
            styledDiv {
                console.log("------- " + window.navigator.platform)

                css {
                    //     backgroundColor = Color.blue
                    display = Display.grid// Display.flex
                    gridTemplateColumns =
                        GridTemplateColumns(GridAutoRows("2fr"), GridAutoRows("1fr"))
                    justifyContent = JustifyContent.center
                    //              alignItems=Align.center
                    columnGap = LinearDimension("1em")
                    rowGap = LinearDimension("1em")
                    width = LinearDimension("70%")
                    margin(top = 80.px)
//               height=LinearDimension("50vh")

                }





                console.log("--- Touch??? --- " + window.navigator.maxTouchPoints + " ---- (  || 'ontouchstart')")

                console.log("---- Oroientation::: " + window.matchMedia("(orientation: portrait)").matches)


                    paths.forEach { path ->


                        styledDiv {
                            css {
                                backgroundColor = Color("#0c2b49")

                                //   display=Display.grid
                                //    alignItems=Align.center
                                //  justifyContent=JustifyContent.center

                                width = LinearDimension.fillAvailable

                                borderRadius = LinearDimension("16px")
gridColumn= GridColumn("1")

                                margin(bottom = LinearDimension("1.25rem"))
                            }






                            styledImg(src = path) {


                                attrs {
                                    width = "100%"
                                    height = "120px"


                                }

                                css {

                                    borderTopRightRadius = LinearDimension("16px")
                                    borderTopLeftRadius = LinearDimension("16px")
                                    overflow = Overflow.hidden
                                }


                            }


                            styledP {
                                +"<b>Titel des Artikels</b>\n"
                                +"Hier passierte etwas. Lesen Sie hier weiter und hier kommt noch Text..."

                                css {

                                    margin(LinearDimension("0.75rem"))
                                }
                            }

                        }
                    }


                styledDiv {
                    css {
                        backgroundColor = Color("#016b6b")

                        width = LinearDimension.fillAvailable
position=Position.fixed
                        gridColumn=GridColumn("2")
                        borderRadius = LinearDimension("16px")


                        margin(bottom = LinearDimension("1.25rem"))
                        padding = "1.5rem"
                    }


                    +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"


                    styledButton {
                        +"Auf dem Laufenden bleiben (push notification)"

                        attrs {

                        }
                    }

                }






                styledDiv {
                    css {
                        backgroundColor = Color("#016b6b")

                        width = LinearDimension.fillAvailable
                        gridColumn=GridColumn("2")
                        borderRadius = LinearDimension("16px")


                        margin(bottom = LinearDimension("12rem"))
                        padding = "1.5rem"
                    }


                    +" Nachrichten rund um Militär- und Protest-Aktionen weltweit und brandaktuell 🔰"


                    styledButton {
                        +"Auf dem Laufenden bleiben (push notification)"

                        attrs {

                        }
                    }

                }
            }


        }
    }


}