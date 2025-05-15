package com.example.bmiextended.ui.chart

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.bmiextended.databinding.FragmentBmiChartBinding

class BmiChartFragment : Fragment() {
    private var _binding: FragmentBmiChartBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiChartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webView: WebView = binding.webviewBmiChart
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/bmi_chart.html")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
