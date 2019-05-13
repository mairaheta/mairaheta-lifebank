
Partial Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Page_Init(sender As Object, e As System.EventArgs) Handles Me.Init

        Dim usrControl As New Control

        If Session("idClient") <> "" Then


        Else

        End If
    End Sub

    Protected Sub Page_Load(sender As Object, e As System.EventArgs) Handles Me.Load



    End Sub
End Class
