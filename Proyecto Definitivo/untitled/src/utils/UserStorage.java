package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserStorage {
    private static HashMap<String, String> userCredentials = new HashMap<>();
    private static ArrayList<String> registeredDoctors = new ArrayList<>();
    private static HashMap<String, List<String>> pacientesAsignados = new HashMap<>();

    public static void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public static boolean validateUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public static void addDoctor(String doctorName) {
        registeredDoctors.add(doctorName);
    }

    public static ArrayList<String> getRegisteredDoctors() {
        return new ArrayList<>(registeredDoctors);
    }

    public static void agregarPacienteAsignado(String medico, String paciente) {
        pacientesAsignados.computeIfAbsent(medico, k -> new ArrayList<>()).add(paciente);
    }

    public static List<String> obtenerPacientesPorMedico(String medico) {
        return pacientesAsignados.getOrDefault(medico, new ArrayList<>());
    }
}
