package com.friquerette.primems.controller.web.converterweb;

import com.friquerette.primems.controller.web.webmodel.AbstractWebModel;
import com.friquerette.primems.core.entity.AbstractEntity;

public interface WebModelConverter<E extends AbstractEntity, W extends AbstractWebModel> {

	public E fromWeb(W web);

	public W toWeb(E entity);
}
