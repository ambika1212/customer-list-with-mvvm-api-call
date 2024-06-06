import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.customerlistdemo.Customer
import com.example.customerlistdemo.R
import kotlin.random.Random

class CustomerAdapter(private val customers: List<Customer>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textView1)
        val mobileTextView: TextView = itemView.findViewById(R.id.textView2)
        val lastNameText: TextView= itemView.findViewById(R.id.textView3)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_list_view, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = customers[position]
        with(holder) {
            nameTextView.text = customer.fName
            nameTextView.setTextColor(getColorForPosition(position))
            mobileTextView.text = customer.mobileNo
            lastNameText.text = customer.lName
            lastNameText.setTextColor(getColorForPosition(position))


            // Randomly select between cow and buffalo image
            val imageResId = if (Random.nextBoolean()) {
                R.drawable.cow
            } else {
                R.drawable.buffalo
            }

            Glide.with(itemView.context)
                .load(imageResId)
                .into(imageView)
        }
    }

    override fun getItemCount() = customers.size

    private fun getColorForPosition(position: Int): Int {
        return when (position % 3) {
            0 -> Color.RED
            1 -> Color.GREEN
            else -> Color.BLUE
        }
    }
}
