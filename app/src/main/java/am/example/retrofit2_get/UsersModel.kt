package am.example.retrofit2_get

    class UsersModel {
        var page: Int? = null
        var data: List<UserData>? = null

        data class UserData(
            var id: Int?,
            var email: String?,
            var first_name: String?,
            var last_name: String?,
            var avatar: String?
        )

}