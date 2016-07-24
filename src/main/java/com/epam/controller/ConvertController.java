package com.epam.controller;

import com.epam.model.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class ConvertController {

    private String result = null;

    @RequestMapping(path="/decimalToBinary",method = RequestMethod.POST)
    public ResponseEntity<String> decimalToBinary(@RequestBody Model model){
        System.out.println("");
        System.out.println("");
        try {
            result = Integer.toBinaryString(Integer.parseInt(model.getInput()));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/decimalToHexadecimal",method = RequestMethod.POST)
    public  ResponseEntity<String> decimalToHexadecimal(@RequestBody Model model){
        try {
            result = Integer.toHexString(Integer.parseInt(model.getInput()));
            result = "{\"output\" : \""+result+"\"}";
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/hexadecimalToDecimal",method = RequestMethod.POST)
    public ResponseEntity<String> hexadecimalToDecimal(@RequestBody Model model){

        int decimal = 0;
        try{
            decimal = Integer.parseInt(model.getInput().trim(), 16);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

        return  new ResponseEntity<String>(""+decimal,HttpStatus.OK);
    }

    @RequestMapping(path = "/binaryToDecimal",method = RequestMethod.POST)
    public ResponseEntity<String> convertToBinary(@RequestBody Model model){

//        StringBuilder output = new StringBuilder();
//        for(int i = 0; i <= model.getInput().length() - 8; i+=8){
//            int k = Integer.parseInt(model.getInput().substring(i, i+8), 2);
//            output.append((char)k);
//        }
        int decimal = 0;
        try{
            decimal = Integer.parseInt(model.getInput(), 2);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

        return  new ResponseEntity<String>(""+decimal,HttpStatus.OK);
    }

    @RequestMapping(path = "/hexadecimalToBinary",method = RequestMethod.POST)
    public ResponseEntity<String> hexadecimalToBinary(@RequestBody Model model){

        try{
            int decimal = Integer.parseInt(model.getInput().trim(), 16);
            result = Integer.toBinaryString(Integer.parseInt(decimal+""));
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        return  new ResponseEntity<String>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/binaryToHexadecimal",method = RequestMethod.POST)
    public ResponseEntity<String> binaryToHexadecimal(@RequestBody Model model){
        try{
            int decimal = Integer.parseInt(model.getInput(), 2);
            result = Integer.toHexString(Integer.parseInt(decimal+""));
            result = "{\"output\" : \""+result+"\"}";
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        return  new ResponseEntity<String>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/stringToBinary",method = RequestMethod.POST)
    public ResponseEntity<String> stringToBinaty(@RequestBody Model model){
        StringBuilder binary = null;
        try {
            byte[] bytes = model.getInput().getBytes();
            binary = new StringBuilder();
            for (byte b : bytes){
                int val = b;
                for (int i = 0; i < 8; i++){
                    binary.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
                binary.append(' ');
            }
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        String result = "{\"output\" : \""+binary.toString()+"\"}";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @RequestMapping(path = "/binaryToString",method = RequestMethod.POST)
    public ResponseEntity<String> binaryToString(@RequestBody Model model) {

        StringBuilder output = new StringBuilder();
        for(int i = 0; i <= model.getInput().length() - 8; i += 8) {
            int k = Integer.parseInt(model.getInput().substring(i, i + 8), 2);
            output.append((char)k);
        }

        String result = "{\"output\" : \""+output.toString()+"\"}";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


//    @PostConstruct
//    public void init(){
//        System.out.println("!");
//    }

}
