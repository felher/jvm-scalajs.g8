package $organization$.$name;format="lower"$
import com.raquo.laminar.api.L.*
import org.felher.beminar.Bem

object Main:
  @main()
  def run(): Unit =
    val bem = Bem("/app")
    val _   = render(
      org.scalajs.dom.document.body,
      div(bem, Shared.msg)
    )
