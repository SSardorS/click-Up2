package uz.pdp.appclickup.service;

import uz.pdp.appclickup.payload.ApiResponse;
import uz.pdp.appclickup.payload.IconDto;

public interface IconService {

    ApiResponse addIcon(IconDto iconDto);
}
