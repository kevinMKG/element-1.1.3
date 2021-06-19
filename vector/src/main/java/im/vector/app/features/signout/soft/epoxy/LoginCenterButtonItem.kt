/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.app.features.signout.soft.epoxy

import android.widget.Button
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import im.vector.app.R
import im.vector.app.core.epoxy.VectorEpoxyHolder
import im.vector.app.core.epoxy.VectorEpoxyModel
import im.vector.app.core.extensions.setTextOrHide

@EpoxyModelClass(layout = R.layout.item_login_centered_button)
abstract class LoginCenterButtonItem : VectorEpoxyModel<LoginCenterButtonItem.Holder>() {

    @EpoxyAttribute var text: String? = null
    @EpoxyAttribute var listener: (() -> Unit)? = null

    override fun bind(holder: Holder) {
        super.bind(holder)

        holder.button.setTextOrHide(text)
        holder.button.setOnClickListener {
            listener?.invoke()
        }
    }

    class Holder : VectorEpoxyHolder() {
        val button by bind<Button>(R.id.itemLoginCenteredButton)
    }
}
