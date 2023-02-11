package com.github.mstavares.babyme.fragments

import android.widget.Toast
import com.github.mstavares.babyme.R
import com.github.mstavares.babyme.databinding.FragmentBabyCardBinding
import com.github.mstavares.babyme.domain.models.Baby
import com.github.mstavares.babyme.domain.models.BabyFilter
import com.github.mstavares.babyme.viewmodels.BabyCardViewModel
import org.koin.android.ext.android.get

class BabyCardFragment : BaseFragmentWithViewModel<FragmentBabyCardBinding, BabyCardViewModel>(R.layout.fragment_baby_card) {

    override fun getViewBinding(): FragmentBabyCardBinding = FragmentBabyCardBinding.inflate(layoutInflater)
    override fun getViewModel(): BabyCardViewModel = get()

    override fun onStart() {
        super.onStart()
        binding.btnFemale.setOnClickListener {
            vm.fetchBaby(BabyFilter.Builder().gender(Baby.Gender.FEMALE).build())
        }
        binding.btnMale.setOnClickListener {
            vm.fetchBaby(BabyFilter.Builder().gender(Baby.Gender.MALE).build())
        }
    }

    override fun onResume() {
        super.onResume()
        vm.baby.observe(this) {
            if(it == null) Toast.makeText(requireContext(), getString(R.string.no_baby_found), Toast.LENGTH_LONG).show()
            else {
                binding.card.setCardBackgroundColor(it.genderColor)
                binding.txtName.text = it.name
                binding.txtYearOfBirth.text = it.yearOfBirth.toString()
                binding.txtGender.text = it.gender
                binding.txtEthnicity.text = it.ethnicity
                binding.txtBabiesWithThisName.text = it.babiesWithThisName.toString()
                binding.txtNameRank.text = it.nameRank.toString()
            }
        }
    }

}