package am.example.retrofit2_get

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val listItems : List<UsersModel.UserData>?): RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val userView = LayoutInflater.from(parent.context).inflate(R.layout.recyceler_row,parent,false)
        return CustomViewHolder(userView)
    }

    override fun getItemCount(): Int {
        if (listItems != null) {
            return listItems.size
        }else return 0
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        listItems?.get(position)?.id?.toString().let { holder.id.setText(it) }
        listItems?.get(position)?.email?.let { holder.email.setText(it) }
        listItems?.get(position)?.first_name?.let { holder.firstName.setText(it) }
        listItems?.get(position)?.last_name?.let { holder.lastName.setText(it) }
        listItems?.get(position)?.avatar?.let { holder.avatar.setText(it) }
    }



    inner class CustomViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView){

        val id = listItemView.findViewById<TextView>(R.id.id)
        val email = listItemView.findViewById<TextView>(R.id.email)
        val firstName = listItemView.findViewById<TextView>(R.id.first_name)
        val lastName = listItemView.findViewById<TextView>(R.id.last_name)
        val avatar = listItemView.findViewById<TextView>(R.id.avatar)
    }
}


