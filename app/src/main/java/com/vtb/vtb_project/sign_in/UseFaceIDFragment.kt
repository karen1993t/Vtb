package com.vtb.vtb_project.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vtb.vtb_project.R
import com.vtb.vtb_project.databinding.FragmentUseFaceIDBinding

class UseFaceIDFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_use_face_i_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bindingUseFaceIDFragment = FragmentUseFaceIDBinding.bind(view)
    }
}