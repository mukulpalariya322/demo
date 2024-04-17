package com.example.vs.testing.demo.token;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.2.
 */
@SuppressWarnings("rawtypes")
public class Token extends Contract {
    public static final String BINARY = "60a06040526040518060400160405280600781526020017f4d494e44504159000000000000000000000000000000000000000000000000008152506040518060400160405280600281526020017f4d50000000000000000000000000000000000000000000000000000000000000815250816003908162000081919062000517565b50806004908162000093919062000517565b50505034600581905550620000ea33620000b26200012b60201b60201c565b600a620000c091906200078e565b6103e8600554620000d29190620007df565b620000de9190620007df565b6200013460201b60201c565b346005819055503373ffffffffffffffffffffffffffffffffffffffff1660808173ffffffffffffffffffffffffffffffffffffffff168152505062000916565b60006012905090565b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603620001a6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016200019d906200088b565b60405180910390fd5b620001ba600083836200029860201b60201c565b8060026000828254620001ce9190620008ad565b92505081905550806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254620002259190620008ad565b925050819055508173ffffffffffffffffffffffffffffffffffffffff16600073ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040516200028c9190620008f9565b60405180910390a35050565b505050565b600081519050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806200031f57607f821691505b602082108103620003355762000334620002d7565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b6000600883026200039f7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8262000360565b620003ab868362000360565b95508019841693508086168417925050509392505050565b6000819050919050565b6000819050919050565b6000620003f8620003f2620003ec84620003c3565b620003cd565b620003c3565b9050919050565b6000819050919050565b6200041483620003d7565b6200042c6200042382620003ff565b8484546200036d565b825550505050565b600090565b6200044362000434565b6200045081848462000409565b505050565b5b8181101562000478576200046c60008262000439565b60018101905062000456565b5050565b601f821115620004c75762000491816200033b565b6200049c8462000350565b81016020851015620004ac578190505b620004c4620004bb8562000350565b83018262000455565b50505b505050565b600082821c905092915050565b6000620004ec60001984600802620004cc565b1980831691505092915050565b6000620005078383620004d9565b9150826002028217905092915050565b62000522826200029d565b67ffffffffffffffff8111156200053e576200053d620002a8565b5b6200054a825462000306565b620005578282856200047c565b600060209050601f8311600181146200058f57600084156200057a578287015190505b620005868582620004f9565b865550620005f6565b601f1984166200059f866200033b565b60005b82811015620005c957848901518255600182019150602085019450602081019050620005a2565b86831015620005e95784890151620005e5601f891682620004d9565b8355505b6001600288020188555050505b505050505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60008160011c9050919050565b6000808291508390505b60018511156200068c57808604811115620006645762000663620005fe565b5b6001851615620006745780820291505b808102905062000684856200062d565b945062000644565b94509492505050565b600082620006a757600190506200077a565b81620006b757600090506200077a565b8160018114620006d05760028114620006db5762000711565b60019150506200077a565b60ff841115620006f057620006ef620005fe565b5b8360020a9150848211156200070a5762000709620005fe565b5b506200077a565b5060208310610133831016604e8410600b84101617156200074b5782820a905083811115620007455762000744620005fe565b5b6200077a565b6200075a84848460016200063a565b92509050818404811115620007745762000773620005fe565b5b81810290505b9392505050565b600060ff82169050919050565b60006200079b82620003c3565b9150620007a88362000781565b9250620007d77fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff848462000695565b905092915050565b6000620007ec82620003c3565b9150620007f983620003c3565b92508282026200080981620003c3565b91508282048414831517620008235762000822620005fe565b5b5092915050565b600082825260208201905092915050565b7f45524332303a206d696e7420746f20746865207a65726f206164647265737300600082015250565b600062000873601f836200082a565b915062000880826200083b565b602082019050919050565b60006020820190508181036000830152620008a68162000864565b9050919050565b6000620008ba82620003c3565b9150620008c783620003c3565b9250828201905080821115620008e257620008e1620005fe565b5b92915050565b620008f381620003c3565b82525050565b6000602082019050620009106000830184620008e8565b92915050565b60805161157462000932600039600061067f01526115746000f3fe6080604052600436106100e15760003560e01c80638da5cb5b1161007f578063a457c2d711610059578063a457c2d7146102e3578063a9059cbb14610320578063dd62ed3e1461035d578063e9ba77fb1461039a576100e8565b80638da5cb5b1461026257806395d89b411461028d57806398c01101146102b8576100e8565b806323b872dd116100bb57806323b872dd14610180578063313ce567146101bd57806339509351146101e857806370a0823114610225576100e8565b806306fdde03146100ed578063095ea7b31461011857806318160ddd14610155576100e8565b366100e857005b600080fd5b3480156100f957600080fd5b506101026103c5565b60405161010f9190610dbb565b60405180910390f35b34801561012457600080fd5b5061013f600480360381019061013a9190610e76565b610457565b60405161014c9190610ed1565b60405180910390f35b34801561016157600080fd5b5061016a610475565b6040516101779190610efb565b60405180910390f35b34801561018c57600080fd5b506101a760048036038101906101a29190610f16565b61047f565b6040516101b49190610ed1565b60405180910390f35b3480156101c957600080fd5b506101d2610580565b6040516101df9190610f85565b60405180910390f35b3480156101f457600080fd5b5061020f600480360381019061020a9190610e76565b610589565b60405161021c9190610ed1565b60405180910390f35b34801561023157600080fd5b5061024c60048036038101906102479190610fa0565b610635565b6040516102599190610efb565b60405180910390f35b34801561026e57600080fd5b5061027761067d565b6040516102849190610fee565b60405180910390f35b34801561029957600080fd5b506102a26106a1565b6040516102af9190610dbb565b60405180910390f35b3480156102c457600080fd5b506102cd610733565b6040516102da9190610efb565b60405180910390f35b3480156102ef57600080fd5b5061030a60048036038101906103059190610e76565b610739565b6040516103179190610ed1565b60405180910390f35b34801561032c57600080fd5b5061034760048036038101906103429190610e76565b61082d565b6040516103549190610ed1565b60405180910390f35b34801561036957600080fd5b50610384600480360381019061037f9190611009565b61084b565b6040516103919190610efb565b60405180910390f35b3480156103a657600080fd5b506103af6108d2565b6040516103bc9190610efb565b60405180910390f35b6060600380546103d490611078565b80601f016020809104026020016040519081016040528092919081815260200182805461040090611078565b801561044d5780601f106104225761010080835404028352916020019161044d565b820191906000526020600020905b81548152906001019060200180831161043057829003601f168201915b5050505050905090565b600061046b6104646108d8565b84846108e0565b6001905092915050565b6000600254905090565b600061048c848484610aa9565b6000600160008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006104d76108d8565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905082811015610557576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161054e9061111b565b60405180910390fd5b610574856105636108d8565b858461056f919061116a565b6108e0565b60019150509392505050565b60006012905090565b600061062b6105966108d8565b8484600160006105a46108d8565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054610626919061119e565b6108e0565b6001905092915050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b7f000000000000000000000000000000000000000000000000000000000000000081565b6060600480546106b090611078565b80601f01602080910402602001604051908101604052809291908181526020018280546106dc90611078565b80156107295780601f106106fe57610100808354040283529160200191610729565b820191906000526020600020905b81548152906001019060200180831161070c57829003601f168201915b5050505050905090565b60055481565b600080600160006107486108d8565b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905082811015610805576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107fc90611244565b60405180910390fd5b6108226108106108d8565b85858461081d919061116a565b6108e0565b600191505092915050565b600061084161083a6108d8565b8484610aa9565b6001905092915050565b6000600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b60065481565b600033905090565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff160361094f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610946906112d6565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16036109be576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109b590611368565b60405180910390fd5b80600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92583604051610a9c9190610efb565b60405180910390a3505050565b600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff1603610b18576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b0f906113fa565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff1603610b87576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b7e9061148c565b60405180910390fd5b610b92838383610d26565b60008060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905081811015610c18576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c0f9061151e565b60405180910390fd5b8181610c24919061116a565b6000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254610cb4919061119e565b925050819055508273ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef84604051610d189190610efb565b60405180910390a350505050565b505050565b600081519050919050565b600082825260208201905092915050565b60005b83811015610d65578082015181840152602081019050610d4a565b60008484015250505050565b6000601f19601f8301169050919050565b6000610d8d82610d2b565b610d978185610d36565b9350610da7818560208601610d47565b610db081610d71565b840191505092915050565b60006020820190508181036000830152610dd58184610d82565b905092915050565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000610e0d82610de2565b9050919050565b610e1d81610e02565b8114610e2857600080fd5b50565b600081359050610e3a81610e14565b92915050565b6000819050919050565b610e5381610e40565b8114610e5e57600080fd5b50565b600081359050610e7081610e4a565b92915050565b60008060408385031215610e8d57610e8c610ddd565b5b6000610e9b85828601610e2b565b9250506020610eac85828601610e61565b9150509250929050565b60008115159050919050565b610ecb81610eb6565b82525050565b6000602082019050610ee66000830184610ec2565b92915050565b610ef581610e40565b82525050565b6000602082019050610f106000830184610eec565b92915050565b600080600060608486031215610f2f57610f2e610ddd565b5b6000610f3d86828701610e2b565b9350506020610f4e86828701610e2b565b9250506040610f5f86828701610e61565b9150509250925092565b600060ff82169050919050565b610f7f81610f69565b82525050565b6000602082019050610f9a6000830184610f76565b92915050565b600060208284031215610fb657610fb5610ddd565b5b6000610fc484828501610e2b565b91505092915050565b6000610fd882610de2565b9050919050565b610fe881610fcd565b82525050565b60006020820190506110036000830184610fdf565b92915050565b600080604083850312156110205761101f610ddd565b5b600061102e85828601610e2b565b925050602061103f85828601610e2b565b9150509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061109057607f821691505b6020821081036110a3576110a2611049565b5b50919050565b7f45524332303a207472616e7366657220616d6f756e742065786365656473206160008201527f6c6c6f77616e6365000000000000000000000000000000000000000000000000602082015250565b6000611105602883610d36565b9150611110826110a9565b604082019050919050565b60006020820190508181036000830152611134816110f8565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061117582610e40565b915061118083610e40565b92508282039050818111156111985761119761113b565b5b92915050565b60006111a982610e40565b91506111b483610e40565b92508282019050808211156111cc576111cb61113b565b5b92915050565b7f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f7760008201527f207a65726f000000000000000000000000000000000000000000000000000000602082015250565b600061122e602583610d36565b9150611239826111d2565b604082019050919050565b6000602082019050818103600083015261125d81611221565b9050919050565b7f45524332303a20617070726f76652066726f6d20746865207a65726f2061646460008201527f7265737300000000000000000000000000000000000000000000000000000000602082015250565b60006112c0602483610d36565b91506112cb82611264565b604082019050919050565b600060208201905081810360008301526112ef816112b3565b9050919050565b7f45524332303a20617070726f766520746f20746865207a65726f20616464726560008201527f7373000000000000000000000000000000000000000000000000000000000000602082015250565b6000611352602283610d36565b915061135d826112f6565b604082019050919050565b6000602082019050818103600083015261138181611345565b9050919050565b7f45524332303a207472616e736665722066726f6d20746865207a65726f20616460008201527f6472657373000000000000000000000000000000000000000000000000000000602082015250565b60006113e4602583610d36565b91506113ef82611388565b604082019050919050565b60006020820190508181036000830152611413816113d7565b9050919050565b7f45524332303a207472616e7366657220746f20746865207a65726f206164647260008201527f6573730000000000000000000000000000000000000000000000000000000000602082015250565b6000611476602383610d36565b91506114818261141a565b604082019050919050565b600060208201905081810360008301526114a581611469565b9050919050565b7f45524332303a207472616e7366657220616d6f756e742065786365656473206260008201527f616c616e63650000000000000000000000000000000000000000000000000000602082015250565b6000611508602683610d36565b9150611513826114ac565b604082019050919050565b60006020820190508181036000830152611537816114fb565b905091905056fea2646970667358221220d69db15175a3b715baf8edca91d17f8b26c58d2903b8324b3857285b6465de0064736f6c63430008130033";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_RECEIVETOKEN = "receiveToken";

    public static final String FUNC_RECEIVEVALUE = "receivevalue";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Token(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Token(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Token(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Token(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

//    public static List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = staticExtractEventParameters(APPROVAL_EVENT, transactionReceipt);
//        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(subtractedValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new Address(160, spender),
                new Uint256(addedValue)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new Address(160, recipient),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

//    public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
//        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
//        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
//        for (Contract.EventValuesWithLog eventValues : valueList) {
//            TransferEventResponse typedResponse = new TransferEventResponse();
//            typedResponse.log = eventValues.getLog();
//            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
//            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
//            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
//            responses.add(typedResponse);
//        }
//        return responses;
//    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String sender, String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new Address(160, sender),
                new Address(160, recipient),
                new Uint256(amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new Address(160, owner),
                new Address(160, spender)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new Address(160, account)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> receiveToken() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RECEIVETOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> receivevalue() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RECEIVEVALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Token load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Token(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Token load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Token(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Token load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Token(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Token load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Token(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Token> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(Token.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<Token> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(Token.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Token> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(Token.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Token> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(Token.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
