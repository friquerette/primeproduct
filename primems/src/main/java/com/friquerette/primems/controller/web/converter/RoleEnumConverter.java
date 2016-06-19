package com.friquerette.primems.controller.web.converter;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.text.WordUtils;

import com.friquerette.primems.core.entity.RoleEnum;

/**
 * A converter for the Enum Role
 * 
 * @author Rick
 *
 */
public class RoleEnumConverter extends PropertyEditorSupport {
	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(RoleEnum.valueOf(WordUtils.capitalizeFully(text.trim())));
	}
}
