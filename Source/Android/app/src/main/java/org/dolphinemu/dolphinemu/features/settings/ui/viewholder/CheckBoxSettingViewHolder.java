package org.dolphinemu.dolphinemu.features.settings.ui.viewholder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.dolphinemu.dolphinemu.R;
import org.dolphinemu.dolphinemu.features.settings.model.view.CheckBoxSetting;
import org.dolphinemu.dolphinemu.features.settings.model.view.SettingsItem;
import org.dolphinemu.dolphinemu.features.settings.ui.SettingsAdapter;

public final class CheckBoxSettingViewHolder extends SettingViewHolder
{
  private CheckBoxSetting mItem;

  private TextView mTextSettingName;
  private TextView mTextSettingDescription;

  private CheckBox mCheckbox;

  public CheckBoxSettingViewHolder(View itemView, SettingsAdapter adapter)
  {
    super(itemView, adapter);
  }

  @Override
  protected void findViews(View root)
  {
    mTextSettingName = (TextView) root.findViewById(R.id.text_setting_name);
    mTextSettingDescription = (TextView) root.findViewById(R.id.text_setting_description);
    mCheckbox = (CheckBox) root.findViewById(R.id.checkbox);
  }

  @Override
  public void bind(SettingsItem item)
  {
    mItem = (CheckBoxSetting) item;

    mTextSettingName.setText(item.getNameId());

    if (item.getDescriptionId() > 0)
    {
      mTextSettingDescription.setText(item.getDescriptionId());
    }
    else
    {
      mTextSettingDescription.setText("");
    }

    mCheckbox.setChecked(mItem.isChecked());
  }

  @Override
  public void onClick(View clicked)
  {
    mCheckbox.toggle();

    getAdapter().onBooleanClick(mItem, getAdapterPosition(), mCheckbox.isChecked());
  }
}
