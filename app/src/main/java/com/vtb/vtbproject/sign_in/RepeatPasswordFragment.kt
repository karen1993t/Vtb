package com.vtb.vtbproject.sign_in

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.vtb.vtbproject.R
import com.vtb.vtbproject.databinding.FragmentRepeatPasswordBinding

class RepeatPasswordFragment : Fragment() {

    var pin2 = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repeat_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bindingRepeatPasswordFragment = FragmentRepeatPasswordBinding.bind(view)
        bindingRepeatPasswordFragment.iconClose.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_enterPasswordFragment_to_enterEmailFragment)
        }

//        val pin1 =activity?.intent?.getStringExtra("pin1")
        val pin1 = "11111"

        val requestFocus = bindingRepeatPasswordFragment.editTextRep.requestFocus()
        bindingRepeatPasswordFragment.editTextRep.inputType = InputType.TYPE_CLASS_NUMBER
        bindingRepeatPasswordFragment.editTextRep.isFocusableInTouchMode
        bindingRepeatPasswordFragment.editTextRep.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {


                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    pin2 = s.toString()


                }

                override fun afterTextChanged(s: Editable?) {
                    when (bindingRepeatPasswordFragment.editTextRep.editableText.toString().length) {
                        1 -> {
                            bindingRepeatPasswordFragment.imageviewRepCircle1.setImageResource(R.drawable.circle2)
                        }
                        2 -> {
                            bindingRepeatPasswordFragment.imageviewRepCircle2.setImageResource(R.drawable.circle2)
                        }
                        3 -> {
                            bindingRepeatPasswordFragment.imageviewRepCircle3.setImageResource(R.drawable.circle2)
                        }
                        4 -> {
                            bindingRepeatPasswordFragment.imageviewRepCircle4.setImageResource(R.drawable.circle2)
                        }
                        5 -> {
                            bindingRepeatPasswordFragment.imageviewRepCircle5.setImageResource(R.drawable.circle2)
                        }
                    }
                    if (pin1 == pin2) {
                        Navigation.findNavController(view)
                            .navigate(R.id.action_repeatPasswordFragment_to_useFaceIDFragment)
                    } else if (bindingRepeatPasswordFragment.editTextRep.editableText.toString().length == 5 && pin1 != pin2) {
                        Toast.makeText(context, "pin codes do not match", Toast.LENGTH_SHORT).show()
                    }


                }

            }
        )


    }


}