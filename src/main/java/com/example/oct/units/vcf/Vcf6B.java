package com.example.oct.units.vcf;

import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;

public class Vcf6B implements Vcf{

        private Api api;
        private Temperature temperature;

        private double a;
        private double b;
        private double vcf;

        @Override
        public double getVcf() {
                return 0;
        }

        @Override
        public Api getApi() {
                return null;
        }

        @Override
        public Temperature getTemp() {
                return null;
        }
}
