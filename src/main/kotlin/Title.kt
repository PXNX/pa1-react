import csstype.Margin
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.*
import styled.*

external interface TitleProps : Props {
    var name: String
}

data class TitleState(val name: String) : State

@JsExport
class Title(props: TitleProps) : RComponent<TitleProps, TitleState>(props) {

    init {
        state = TitleState(props.name)
    }

    override fun RBuilder.render() {
styledBody {

    css {

        background= "#fdfdfd";
        fontFamily= "Nunito"
        fontSize=LinearDimension("1rem")
    }

    h1 {
        +"Hello, ${state.name}"
    }

    styledUl {
        styledLi {
            +"Home"
            css {
                margin(right = LinearDimension("0.5rem"))
            }
        }
        styledLi {
            +"Home"
            css {
                margin(right = LinearDimension("0.5rem"))
            }
        }
        styledLi {
            +"Home"
            css {
                margin(right = LinearDimension("0.5rem"))
            }
        }

        css {
            listStyleType = ListStyleType.none
            display = Display.flex
        }
    }


    input {
        attrs {
            type = InputType.text
            value = state.name
            onChangeFunction = { event ->
                setState(
                    TitleState(name = (event.target as HTMLInputElement).value)
                )
            }
        }
    }



    styledDiv {

        css {
            put("", "")
            //    position=Position.relative
            backgroundColor = Color.blue
            //  position = Position.absolute
            //  alignContent=Align.center
            //  Align.center
            //  padding="200px"
            //   margin= margin(LinearDimension.auto).toString()
            //  width= LinearDimension("50%")

            // top = 10.px
            // right = 10.px

            //   display=Display.flex

            //  alignItems=Align.center
            //  justifyContent=JustifyContent.center
            display =Display.grid// Display.flex
            gridTemplateColumns= GridTemplateColumns(GridAutoRows("1fr"), GridAutoRows("1fr"))
            justifyContent = JustifyContent.center
            //              alignItems=Align.center


            height=1000.px
//               height=LinearDimension("50vh")

        }


        val paths = emptyList<String>().toMutableList()

        for (i in 0..8) {
            paths.addAll(listOf("wallpaper1.webp", "wallpaper2.jpg", "wallpaper3.png"))
        }
     /*   styledDiv {
            css {
                backgroundColor = Color.darkGreen

                //   display=Display.grid
                //    alignItems=Align.center
                //  justifyContent=JustifyContent.center

                width = 200.px

                //  width= LinearDimension("50%")
            }

      */

            for (path in paths) {
                img(src = path) {


                    attrs {
                        width = "140"
                        height = "90"


                    }


                }

        //    }
        }

    }
}
    }
}
