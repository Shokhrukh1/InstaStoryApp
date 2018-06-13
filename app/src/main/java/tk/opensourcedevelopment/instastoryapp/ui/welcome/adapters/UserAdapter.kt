package tk.opensourcedevelopment.instastoryapp.ui.welcome.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.niekirk.com.instagram4android.requests.payload.InstagramSearchUsersResultUser
import kotlinx.android.synthetic.main.item_user.view.*
import tk.opensourcedevelopment.instastoryapp.R
import tk.opensourcedevelopment.instastoryapp.ui.base.OnItemClickListener
import tk.opensourcedevelopment.instastoryapp.util.extension.loadImage

class UserAdapter(var listener: OnItemClickListener<InstagramSearchUsersResultUser>, var users: List<InstagramSearchUsersResultUser> = ArrayList()) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users.get(position))
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: InstagramSearchUsersResultUser) {
            itemView.tvUserName.text = user.username
            itemView.tvFullName.text = user.full_name

            itemView.ivAvatar.loadImage(user.profile_pic_url)

            itemView.setOnClickListener {
                listener.onItemClick(users.get(adapterPosition))
            }
        }
    }
}