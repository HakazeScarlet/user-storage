package user;

import encryptor.EncryptionService;

public class UserService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;

    public UserService(UserRepository userRepository, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
    }

    public void save(User user) {
        String email = user.getEmail();
        user.setEmail(email);
        String name = user.getName();
        user.setName(name);
        String surname = user.getSurname();
        user.setSurname(surname);
        String phone = user.getPhone();
        user.setPhone(phone);
        String country = user.getCountry();
        user.setCountry(country);
        String password = user.getPassword();
        String encryptedPassword = encryptionService.encrypt(password);
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }
}
