Imports Microsoft.VisualBasic

Public Class Elements

    Public Class loginRequest

        Private _user As String
        Private _pass As String

        Public Property usuario() As String
            Get
                Return _user

            End Get
            Set(value As String)
                _user = value
            End Set
        End Property
        Public Property password() As String
            Get
                Return _pass

            End Get
            Set(value As String)
                _pass = value
            End Set
        End Property

    End Class

    Public Class loginResponse
        Private _header As Header
        Private _body As Body


        Public Property header() As Header
            Get
                Return _header
            End Get
            Set(value As Header)
                _header = value
            End Set
        End Property
        Public Property body() As Body
            Get
                Return _body
            End Get
            Set(value As Body)
                _body = value
            End Set
        End Property

    End Class

    Public Class Header

        Private _code As String
        Private _message As String

        Public Property code() As String
            Get
                Return _code

            End Get
            Set(value As String)
                _code = value
            End Set
        End Property
        Public Property message() As String
            Get
                Return _message

            End Get
            Set(value As String)
                _message = value
            End Set
        End Property
    End Class

    Public Class Body

        Private _tkn As String
        Public Property tkn() As String
            Get
                Return _tkn

            End Get
            Set(value As String)
                _tkn = value
            End Set
        End Property
    End Class
End Class
