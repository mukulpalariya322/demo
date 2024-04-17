package com.example.vs.testing.demo;

import com.example.vs.testing.demo.token.Token;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);
//		Web3j client=Web3j.build(
//				new HttpService("https://polygon-mumbai.g.alchemy.com/v2/idljWl5vJre3dCEsqYfIxqz4rNqs7iyB")
//		);
//
//		final String ethAddress="0x4c01E9F07106e1144942f758db0bA848E855afe5";
//		final EthGetBalance balanceresponse=client.ethGetBalance(ethAddress,
//						DefaultBlockParameter.valueOf("latest"))
//				.sendAsync().get(10, TimeUnit.SECONDS);
//
//		final BigInteger unscaleBalance=balanceresponse.getBalance();
//		System.out.println("unscalebalance"+unscaleBalance);
//		final BigDecimal scalebalance= new BigDecimal(unscaleBalance)
//				.divide(new BigDecimal(1000000000000000000L),18, RoundingMode.HALF_UP);
//		System.out.println("scale balance :- "+scalebalance);
////		String privateKey = "99c3f935708014e710f3c9f02f7c54a2448c26891a2de3b075c021ec9cbc5e18";
////		Credentials credentials = Credentials.create(privateKey);
////		int chain_ID=80001;
////		TransactionManager transactionManager= new RawTransactionManager(client,credentials,chain_ID);
////
////		Token tokencontact=Token.deploy(client, transactionManager,new DefaultGasProvider(),BigInteger.valueOf(10)).send();
////		String contractaddress=tokencontact.getContractAddress();
////		System.out.println(contractaddress);
//	}

	}
}