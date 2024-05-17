package com.avereon.farragut.port.inbound;

import com.avereon.farragut.core.model.Company;

public interface CompanyCommand {

	Company createCompany( Company company );

}
