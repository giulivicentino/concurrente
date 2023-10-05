/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author nacho
 */
public class Gestor {
    private Semaphore llegadaMecanico = new Semaphore(0);
    private Semaphore llegadaElectrico = new Semaphore(0);
}
