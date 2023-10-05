package demo_04.model.service.mapper.menu;

import demo_04.model.dto.request.MenuRequest;
import demo_04.model.dto.response.MenuResponse;
import demo_04.model.entity.Menu;
import demo_04.model.service.mapper.IGenericMapper;

public interface IMenuMapper extends IGenericMapper<Menu, MenuRequest, MenuResponse> {
}
