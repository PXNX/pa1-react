import kotlinx.css.*
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.img
import styled.css
import styled.styledCol
import styled.styledDiv


@OptIn(ExperimentalJsExport::class)
@JsExport
class Feed : RComponent<Props, State>() {
    override fun RBuilder.render() {


      styledDiv {


          css {
              backgroundColor = Color.blue
              display = Display.grid// Display.flex
              gridTemplateColumns = GridTemplateColumns(GridAutoRows("1fr"))
              justifyContent = JustifyContent.center
              //              alignItems=Align.center

              height = 1000.px

              margin(top = 100.px)
//               height=LinearDimension("50vh")

          }


          val paths = emptyList<String>().toMutableList()

          for (i in 0..8) {
              paths.addAll(listOf("wallpaper1.webp", "wallpaper2.jpg", "wallpaper3.png"))
          }


          for (path in paths) {

              styledDiv {
                  css {
                      backgroundColor = Color.darkGreen

                      //   display=Display.grid
                      //    alignItems=Align.center
                      //  justifyContent=JustifyContent.center

                      width = LinearDimension.fillAvailable

                      filter = "<filter id=\"round\">\n" +
                              "  <feGaussianBlur in=\"SourceGraphic\" stdDeviation=\"5\" result=\"blur\" />\n" +
                              "  <feColorMatrix in=\"blur\" mode=\"matrix\" values=\"1 0 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 19 -9\" result=\"goo\" />\n" +
                              "  <feComposite in=\"SourceGraphic\" in2=\"goo\" operator=\"atop\"/>\n" +
                              "</filter>\n"
                  }




                  img(src = path) {


                      attrs {
                          width = "100%"
                          height = "120px"


                      }


                  }


                  styledDiv {
                      +"<b>Titel des Artikels</b>\n"
                      +"Hier passierte etwas. Lesen Sie hier weiter und hier kommt noch Text..."

                      css {

                          margin(left=LinearDimension("0.75rem"),right = LinearDimension("0.75rem"), top=LinearDimension("1rem"), bottom = LinearDimension("2.5rem"))
                      }
                  }

              }
          }
      }
    }


}