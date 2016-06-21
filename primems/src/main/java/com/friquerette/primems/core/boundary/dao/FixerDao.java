package com.friquerette.primems.core.boundary.dao;

import com.friquerette.primems.core.boundary.entity.CurrencyEnum;
import com.friquerette.primems.core.boundary.entity.Fixer;

public interface FixerDao {

	public Fixer latest();

	public Fixer latest(CurrencyEnum origin, CurrencyEnum... source);

}
