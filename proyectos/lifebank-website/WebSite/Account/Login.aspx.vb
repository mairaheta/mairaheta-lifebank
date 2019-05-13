Imports System.Runtime.Serialization.Json
Imports System.Net
Imports System.IO
Imports System.Configuration.ConfigurationManager
Imports Elements

Partial Class Account_Login
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        If IsPostBack Then

            Dim usrControl As New TextBox
            usrControl = LoginUser.FindControl("UserName")

            Dim passControl As New TextBox
            passControl = LoginUser.FindControl("Password")

            Dim authRequest As New Elements.loginRequest
            authRequest.usuario = usrControl.Text
            authRequest.password = passControl.Text


            Dim data = Encoding.UTF8.GetBytes(serializerObjects(authRequest))
            Dim myString As String = AppSettings("LOGIN_URL")

            Dim result_post = SendRequest(New Uri(myString), data, "application/json", "POST")

            If Not String.IsNullOrEmpty(result_post) Then
                Dim authResponse As loginResponse = deserializerObjects(result_post)
                Session("idClient") = authRequest.usuario
                Response.Redirect("../Default.aspx")
            End If


        End If


    End Sub

    Private Function SendRequest(uri As Uri, jsonDataBytes As Byte(), contentType As String, method As String) As String
        Dim req As HttpWebRequest = WebRequest.Create(uri)
        req.ContentType = contentType
        req.Method = method
        req.ContentLength = jsonDataBytes.Length


        Dim stream = req.GetRequestStream()
        stream.Write(jsonDataBytes, 0, jsonDataBytes.Length)
        stream.Close()

        Dim response As HttpWebResponse

        response = req.GetResponse()

        If response.StatusCode = HttpStatusCode.OK Then

            Dim dataStream As Stream
            dataStream = response.GetResponseStream()

            Dim reader As New StreamReader(dataStream)
            Dim res = reader.ReadToEnd()
            reader.Close()
            response.Close()
            Return res
        End If

        Return String.Empty
    End Function


    ''' <summary>
    ''' Funcion para serializar objetos a JSON
    ''' </summary>
    ''' <param name="pObject">Objeto a serializar</param>
    ''' <returns></returns>
    ''' <remarks></remarks>
    Public Function serializerObjects(ByVal pObject As Object) As String

        Dim textJson As String
        Dim jsonSerializer As New DataContractJsonSerializer(pObject.GetType)
        Dim ms As New IO.MemoryStream

        jsonSerializer.WriteObject(ms, pObject)
        textJson = Encoding.UTF8.GetString(ms.ToArray)

        ms.Dispose()
        Return textJson

    End Function

    ''' <summary>
    ''' Funcion para deserializar objetos a JSON
    ''' </summary>
    ''' <param name="json">Objeto a serializar</param>
    ''' <returns></returns>
    ''' <remarks></remarks>
    Public Function deserializerObjects(ByVal json As String) As loginResponse

        Dim obj As New loginResponse
        Dim ms As New MemoryStream(Encoding.Unicode.GetBytes(json))
        Dim serializer As New System.Runtime.Serialization.Json.DataContractJsonSerializer(obj.[GetType]())
        'obj = DirectCast(serializer.ReadObject(ms), List(Of loginResponse))
        obj = serializer.ReadObject(ms)
        ms.Close()
        ms.Dispose()
        Return obj


    End Function

End Class