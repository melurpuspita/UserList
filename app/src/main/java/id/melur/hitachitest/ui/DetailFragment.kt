package id.melur.hitachitest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import id.melur.hitachitest.R
import id.melur.hitachitest.database.UserDetail
import id.melur.hitachitest.databinding.FragmentDetailBinding
import id.melur.hitachitest.helper.Result
import id.melur.hitachitest.viewmodel.ViewModel

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by viewModels()

    private val observer: Observer<Result<UserDetail>> = Observer { result ->
        when (result) {
            is Result.Loading -> {
                binding.linearDetail.visibility = View.GONE
            }
            is Result.Success -> {
                val user = result.data
                onUpdateLayout(user)
            }
            is Result.Error -> {}
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString("username")
        viewModel.getUserData(username!!).observe(viewLifecycleOwner, observer)
    }

    private fun onUpdateLayout(data: UserDetail?){
        if(data != null){
            binding.circularProgressBar.visibility = View.GONE
            binding.linearDetail.visibility = View.VISIBLE
            Glide.with(context!!)
                .load(data.avatarUrl)
                .fitCenter()
                .into(binding.imgUserPhoto)

            binding.txtUsername.text = data.login
            binding.txtName.text = data.name
            binding.txtCompany.text = data.company
            binding.txtBlog.text = data.blog
            binding.txtLocation.text = data.location
            binding.txtFollowingCount.text = data.following.toString()
            binding.txtFollowersCount.text = data.followers.toString()
            binding.txtReposCount.text = data.publicRepos.toString()
            binding.txtGistsCount.text = data.publicGists.toString()
        }
    }

}