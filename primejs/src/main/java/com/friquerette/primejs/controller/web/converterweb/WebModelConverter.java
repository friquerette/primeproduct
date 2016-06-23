package com.friquerette.primejs.controller.web.converterweb;

import com.friquerette.primejs.controller.web.webmodel.AbstractWebModel;
import com.friquerette.primejs.core.entity.AbstractEntity;

public interface WebModelConverter<E extends AbstractEntity, W extends AbstractWebModel> {

	public E fromWeb(W web);

	public W toWeb(E entity);
}
