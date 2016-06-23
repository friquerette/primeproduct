package com.friquerette.primejs.controller.web.converterenum;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.text.WordUtils;

import com.friquerette.primejs.core.entity.GenderEnum;

/**
 * A converter for the Enum Gender
 * 
 * @author Rick
 *
 */
public class GenderEnumConverter extends PropertyEditorSupport {
	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(GenderEnum.valueOf(WordUtils.capitalizeFully(text.trim())));
	}
}
