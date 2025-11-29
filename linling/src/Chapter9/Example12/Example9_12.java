package Chapter9.Example12;

import java.io.*;

public class Example9_12 {
    public static void main(String args[]) {
        // 定义要加密的命令
        String command = "渡江总攻时间是4月22日晚10点";
        
        // 创建 EncryptAndDecrypt 类的实例，用于执行加密和解密操作
        EncryptAndDecrypt person = new EncryptAndDecrypt();
        
        // 定义加密密码
        String password = "Tiger";
        
        // 使用 encrypt 方法加密命令
        String secret = person.encrypt(command, password); 
        
        // 创建 File 对象，指向存储加密数据的文件
        File file = new File("src\\Chapter9\\Example12\\secret.txt");
        
        try {
            // 创建 FileOutputStream 实例，用于写入文件
            FileOutputStream fos = new FileOutputStream(file);
            
            // 创建 DataOutputStream 实例，包装 FileOutputStream 以便能够写入 UTF 编码的字符串
            DataOutputStream outData = new DataOutputStream(fos);
            
            // 将加密后的字符串写入文件
            outData.writeUTF(secret);
            
            // 打印加密后的命令
            System.out.println("加密命令:" + secret);
        } catch (IOException e) {
            // 捕获并处理可能发生的 I/O 异常
        }
        
        try {
            // 创建 FileInputStream 实例，用于从文件读取数据
            FileInputStream fis = new FileInputStream(file);
            
            // 创建 DataInputStream 实例，包装 FileInputStream 以便能够读取 UTF 编码的字符串
            DataInputStream inData = new DataInputStream(fis);
            
            // 从文件中读取加密后的字符串
            String str = inData.readUTF();
            
            // 使用 decrypt 方法解密读取的字符串
            String mingwen = person.decrypt(str, password);
            
            // 打印解密后的命令
            System.out.println("解密命令:" + mingwen);
        } catch (IOException e) {
            // 捕获并处理可能发生的 I/O 异常
        }
    }
}
