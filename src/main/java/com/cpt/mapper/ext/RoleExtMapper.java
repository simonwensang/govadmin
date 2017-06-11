package com.cpt.mapper.ext;

import com.cpt.model.Role;

public interface RoleExtMapper {

	Role selectByUserId(Long userId);
}
