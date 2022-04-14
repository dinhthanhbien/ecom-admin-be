package com.vnpay.isp.be.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vnpay.isp.be.dto.response.Response;
import com.vnpay.isp.be.model.Issuer;
import com.vnpay.isp.be.model.RecurringInfo;
import com.vnpay.isp.be.service.CategoryService;

/**
 * @author sonnt2 (sonnt2@vnpay.vn)
 * 12/30/2020
 **/
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("get-translations")
    public ResponseEntity<Map<String, String>> getTranslations(@RequestParam String lang) {
        Map<String, String> translations = categoryService.getTranslations(lang);
        return ResponseEntity.ok(translations);
    }

    @GetMapping("get-error-text")
    public ResponseEntity<String> getErrorText(@RequestParam String label, @RequestParam String lang) {
        String text = categoryService.getErrorText(label, lang);
        return ResponseEntity.ok(text);
    }

    @GetMapping("get-issuers")
    public ResponseEntity<Response<List<Issuer>>> getIssuers(@RequestParam String accessToken) {
        Response<List<Issuer>> response = categoryService.getIssuers(accessToken);
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-schemes")
    public ResponseEntity<Response<List<String>>> getSchemes(@RequestParam String accessToken, @RequestParam String issuerCode) {
        Response<List<String>> response = categoryService.getSchemes(accessToken, issuerCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping("get-recurring-info")
    public ResponseEntity<Response<List<RecurringInfo>>> getRecurringInfo(@RequestParam String accessToken, @RequestParam String issuerCode, @RequestParam String scheme) {
        Response<List<RecurringInfo>> response = categoryService.getRecurringInfo(accessToken, issuerCode, scheme);
        return ResponseEntity.ok(response);
    }
}
