package id.melur.hitachitest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.melur.hitachitest.R
import id.melur.hitachitest.adapter.DataAdapter
import id.melur.hitachitest.database.User
import id.melur.hitachitest.databinding.FragmentMainBinding
import id.melur.hitachitest.helper.Result
import id.melur.hitachitest.viewmodel.ViewModel

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataAdapter: DataAdapter
    private val viewModel: ViewModel by viewModels()

    private val observer: Observer<Result<List<User>>> = Observer { result ->
        when (result) {
            is Result.Loading -> {}
            is Result.Success -> {
                val user = result.data
                dataAdapter.submitList(user)
            }
            is Result.Error -> {}
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromAPI()
    }

    private fun getDataFromAPI() {
        viewModel.getData().observe(viewLifecycleOwner, observer)

        binding.rvUser.apply {
            dataAdapter = DataAdapter()
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dataAdapter
        }
    }
}