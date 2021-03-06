package tech.takenoko.screenmirror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import tech.takenoko.screenmirror.view.BaseFragment
import tech.takenoko.screenmirror.view.FragmentMainPage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.also {
            it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            it.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        }

        supportFragmentManager.beginTransaction().run {
            add(R.id.fragment_frame, FragmentMainPage())
            commit()
        }
    }

    fun pushFragment(fragment: BaseFragment<*>) {
        supportFragmentManager.beginTransaction().run {
            replace(R.id.fragment_frame, fragment)
            commit()
        }
    }
}
