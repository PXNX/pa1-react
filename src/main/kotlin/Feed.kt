import kotlinx.css.*
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.img
import styled.css
import styled.styledDiv
import styled.styledImg


@OptIn(ExperimentalJsExport::class)
@JsExport
class Feed : RComponent<Props, State>() {
    override fun RBuilder.render() {

        styledDiv {

            css {
                backgroundColor = Color.blue
                display = Display.grid// Display.flex
                gridTemplateColumns = GridTemplateColumns(GridAutoRows("1fr"), GridAutoRows("1fr"))
                justifyContent = JustifyContent.center
                //              alignItems=Align.center

                height = 1000.px
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
            }
        }
    }
}